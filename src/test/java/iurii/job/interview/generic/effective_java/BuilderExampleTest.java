package iurii.job.interview.generic.effective_java;

public class BuilderExampleTest {

    static class Parent {
        private final int mandatoryParentField;
        private int parentField;

        // main constructor
        private Parent(final int mandatoryParentField) {
            this.mandatoryParentField = mandatoryParentField;
        }

        // telescoping constructor technique (using mandatory constructor and optional parameter)
        // ! builder is better option than telescoping in terms of readability
        private Parent(final int mandatoryParentField, final int parentField) {
            this(mandatoryParentField);
            this.parentField = parentField;
        }

        // java bean pattern is bad, because of non immutability, inconsistent state, not atomic create operation
        // builder is safer option than java bean

        // builder simulates optional named parameters in python, scala
        private Parent(final ParentBuilder builder) {
            this.mandatoryParentField = builder.mandatoryParentField;
            this.parentField = builder.parentField;

        }

        // builder pattern with generic type and recursive type parameter!
        interface BuilderInterface<T extends BuilderInterface<T>> {
            // pattern to get access to "this" instance. in java known as simulated self type idiom
            // for type hierarchy done via recursive type parameter
            T self();
        }

        // builder pattern with generic type and recursive type parameter!
        public static class ParentBuilder implements BuilderInterface<ParentBuilder> {
            private final int mandatoryParentField;
            private int parentField;

            ParentBuilder(final int mandatoryParentField) {
                this.mandatoryParentField = mandatoryParentField;
            }

            // returning this allows fluent API or method chaining
            ParentBuilder withParentId(final int parentField) {
                this.parentField = parentField;
                return self();
            }

            @Override
            public ParentBuilder self() {
                return this;
            }

            Parent build() {
                return new Parent(this);
            }

        }
    }

    static class Child extends Parent {

        private final int mandatoryChildField;
        private int childField;

        private Child(int mandatoryParentField, int mandatoryChildField) {
            super(mandatoryParentField);
            this.mandatoryChildField = mandatoryChildField;
        }

        private Child(int mandatoryParentField, int mandatoryChildField, int childField) {
            super(mandatoryParentField);
            this.mandatoryChildField = mandatoryChildField;
            this.childField = childField;
        }

        private Child(final ChildBuilder builder) {
            super(builder);
            mandatoryChildField = builder.mandatoryChildField;
            childField = builder.childField;
        }

        // parallel hierarchy for builders can be done
        // defining self method allows to to fluent API calls on subclasses without doing the cast
        public static class ChildBuilder extends ParentBuilder {

            private final int mandatoryChildField;
            private int childField;

            ChildBuilder(int mandatoryParentField, int mandatoryChildField) {
                super(mandatoryParentField);
                this.mandatoryChildField = mandatoryChildField;
            }

            ChildBuilder withChildField(final int childField) {
                this.childField = childField;
                return self();
            }

            @Override
            public ChildBuilder self() {
                return this;
            }

            // covariant return type
            @Override
            Child build() {
                return new Child(this);
            }
        }
    }

}
