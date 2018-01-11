package iurii.job.interview.generic.java8;


import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.LongUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    interface Equals {
        /*default boolean equals(Object o) {
            return true;
        }*/ // not possible! Object contains!
        default void someMethod() {
            System.out.println("Equals in some Method");
        }

        /*static boolean someMethod() {
            System.out.println(" static in some Method");
            return true;
        }*/ // not possible! someMethod is defined!

        static boolean someMethod1() {
            System.out.println("Equals static in some Method1");
            return true; // valid
        }
    }

    static class EqualsImpl implements Equals {
        static boolean someMethod1() {
            System.out.println("EqualsImpl static in some Method1");
            return true; // valid, because static method
        }

        public void someMethod() {
            System.out.println("EqualsImpl in some Method");
        } // valid, because override interface default method
    }

    static class Name {
        private final String name;

        Name(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }

    public static final Period PERIOD_DAYS = Period.ofDays(7);

    public static void main(String[] args) {
        // Optional
        // Optional.of(null); // Null pointer
        Optional<Integer> emptyOptional = Optional.empty();
        Optional<Integer> nullableOptional = Optional.ofNullable(null);
        Optional<Integer> fiveOptional = Optional.ofNullable(5);
        System.out.println("Nullable.equals.Empty = " + emptyOptional.equals(nullableOptional));
        System.out.println("emptyOrElse = " + emptyOptional.orElse(5));
        System.out.println("fiveOptional = " + fiveOptional);
        System.out.println("fiveOptionalGet = " + fiveOptional.get());
        System.out.println("fiveOptionalGet = " + fiveOptional.orElse(6));
        System.out.println("fiveOptionalGet = " + fiveOptional.orElseGet(() -> 7));

        // ------------- JDBC ---------------


        // Class.forName("com.mysql.jdbc.Driver")
        // Connection DriverManager.getConnection("jdbc://[localhost]:3306", "user", "password")

        //--------------- Exception handling -----------------
        try {
            String s = null;
            s.length(); // this will be thrown
        } catch (NullPointerException e) {

        } finally {
            try {
                //int i = Integer.parseInt(args[0]); // ArrayIndexOutOfBoundsException
                int k = Integer.parseInt("1ee"); // ArrayIndexOutOfBoundsException
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException"); //
            } finally {
                System.out.println("Finally");
            }
        }

        // -------------- Data structures ---------------------------

        List<Integer> intArr = new ArrayList<Integer>();
        intArr.add(1);
        intArr.add(2);
        intArr.add(3);
        intArr.add(4);
        intArr.removeIf(e -> e % 2 == 0);
        System.out.println(intArr);

        TreeSet treeSet = new TreeSet(); // only TreeSet has pollFirst and ceiling
        treeSet.add("A");
        treeSet.add("D");
        treeSet.pollFirst(); // no poll method
        System.out.println(treeSet.ceiling("D"));

        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.replace(1, "1", null); // replace if key and value to value. But value is different - no replace
        map.replace(3, null); // null is a valid value
        //map.putIfAbsent(null, null); // null if not supported by default. Only if comparator supports
        System.out.println(map.keySet());
        System.out.println(map.values());

        System.out.println(Arrays.asList("Fred", "Jim", "Sheila")
                .stream()
                .peek(System.out::println)
                .allMatch(s -> s.startsWith("F")));

        Map map1 = new HashMap();
        map1.put("One", 1);
        map1.put("Two", 2);
        map1.put("Three", 3);
        map1.put("Four", 4);
        System.out.println(new TreeMap(map1).ceilingKey("O"));

        ArrayDeque ad = new ArrayDeque();
        ad.add(6);
        ad.add(2);
        ad.offerLast(3);
        ad.offer(4);
        ad.poll();
        System.out.println(ad);

        // -------------- Functional programming --------------------
        // unary operator composition
        LongUnaryOperator longUnaryOperator2x = x -> 2 * x;
        LongUnaryOperator longUnaryOperator1PlusX = x -> 1 + x;

        System.out.println(
                longUnaryOperator2x.compose(longUnaryOperator1PlusX).andThen(longUnaryOperator1PlusX)
                        .applyAsLong(5));

        // stream
        Stream<String> stream = Stream.of("Cat", "Dog", "Rat");
        System.out.println(stream.flatMap(st -> Stream.of(st.length())).collect(Collectors.toSet()));

        // ranges inclusive, exclusive
        IntStream.range(0, 9).forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(0, 9).forEach(System.out::print);
        System.out.println();

        // comparator
        Comparator<Name> stringComparator = Comparator.comparing(Name::getName);
        System.out.println(stringComparator.compare(new Name("Aaa"), new Name("Bccc")));

        Comparator<Integer> integerComparator = Integer::compare;
        System.out.println(integerComparator.compare(3, 2));

        Comparable<String> compString = s -> s.hashCode();

        Stream.of(3,6,0,4).sorted().peek(System.out::print).findFirst(); // zero is printed

        Stream ints = Stream.of(1,2,3);
        long count = ints.skip(1).limit(1).count(); // long value!!

        System.out.println("Count = " + count);

        String[] s = new String[2];

        //System.out.println(Optional.of(s[1]).orElse("empty")); // Null pointer -> use Optional.ofNullable

        System.out.println("Null Last = " +Comparator.nullsLast(Integer::compare).compare(null, 10));

        // --------------- Localization -----------------
        System.out.println(DateFormat.getDateInstance(DateFormat.LONG, new Locale("fr")).format(new Date()));

        Locale localeBuilder = new Locale.Builder().setLanguage("en").setRegion("US").build();
        System.out.println(localeBuilder.getDisplayLanguage(new Locale("fr"))); // "anglais" in English language

        // -------------- Date Time API ----------------------

        // use of Local time api
        System.out.println(LocalTime.ofSecondOfDay(36000));
        System.out.println(LocalTime.ofSecondOfDay(36000).atOffset(ZoneOffset.UTC));

        // use offset time
        System.out.println(OffsetTime.now());

        // use of period
        System.out.println(LocalDate.parse("2016-01-26").plus(PERIOD_DAYS));
        System.out.println(LocalDate.parse("2010-01-21").plus(PERIOD_DAYS).plus(PERIOD_DAYS));

        // compare two dates. not equal because of leap year
        System.out.println(LocalDate.of(2012, 12, 31));
        System.out.println(LocalDate.ofYearDay(2012, 365));

        //
        LocalDate date1 = LocalDate.of(2016, Month.JANUARY, 1);
        LocalDateTime date2 = LocalDateTime.of(2017, Month.JUNE, 1, 1, 1);
        //Period p = Period.between(date2, date2); between localDates only!

        Period periodYMD = Period.of(1,2,1);
        LocalDate loc = LocalDate.of(2015,1,1);
        System.out.println(loc.plusDays(periodYMD.getDays()));

        MonthDay.of(10,28); // month, day of month

        LocalDate loc1 = LocalDate.of(2015,1,27);
        LocalDate loc2 = LocalDate.of(2015,1,31);
        //System.out.println(Duration.between(loc1, loc2)); unsupported

        System.out.println(LocalDate.parse("2014-05-04").format(DateTimeFormatter.ISO_DATE));
                //.format(DateTimeFormatter.ISO_DATE_TIME));
        // java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: HourOfDay

        // ------------------ IO Streams ------------------------------
        // console
        Console console = System.console();
        //char[] chars = console.readPassword(); // password is in chars!

        // input stream to read specific amount
        try (InputStream inputStream = new ByteArrayInputStream("abcdefghigklmn".getBytes(StandardCharsets.UTF_8.name()))) {
            byte[] buffer = new byte[10];
            int read = inputStream.read(buffer);
            System.out.println(read);
            for (byte c : buffer) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // get owner
        Path path = Paths.get(".");
        try {
            BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println(basicFileAttributes.size()
                    + " " + basicFileAttributes.creationTime()
                    + " " + basicFileAttributes.fileKey()
                    + " " + basicFileAttributes.isDirectory()
                    + " " + basicFileAttributes.isOther()
                    + " " + basicFileAttributes.isRegularFile()
                    + " " + basicFileAttributes.isSymbolicLink()
                    + " " + basicFileAttributes.lastAccessTime()
                    + " " + basicFileAttributes.lastModifiedTime()); // no method getOwner
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(Files.getOwner(path)); // works!
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Map mp = Files.readAttributes(path, "*");
            System.out.println(mp); // no owner
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*try {
            List<String> strings = Files.readAllLines(Paths.get("input.txt")); // not a stream
        } catch (IOException e) {
            e.printStackTrace(); // no such file exception
        }*/

        /*FileReader fr = new FileReader("new.txt"); // content ABCD
        System.out.println(fr.read()); // reads first character A to int 65
        fr.close();*/

        Path p1 = Paths.get("in\\new");
        Path p2 = Paths.get("file.txt");
        System.out.println(p1.resolve(p2));

        // ------------- Concurrency ----------------
        // atomic
        AtomicInteger atomicInteger = new AtomicInteger(10);
        System.out.println(atomicInteger.decrementAndGet());

        // executor with callable, runnable, future
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            // executor service - may submit in the same thread thread.start - always new Thread
            Runnable runnable1 = () -> System.out.println("Runnable");
            Future<?> runnable = executorService.submit(runnable1);
            Callable<Integer> callable1 = () -> {
                System.out.println("Callable");
                return 1;
            };
            Future<Integer> callable = executorService.submit(callable1);
            executorService.execute(runnable1); // only runnable !
        } finally {
            executorService.shutdown();
        }

        // ----------------- interfaces, classes, etc. ------
        Equals.someMethod1();
        EqualsImpl.someMethod1();
        new EqualsImpl().someMethod();

        try (MyResource1 r1 = new MyResource1();
             MyResource2 r2 = new MyResource2();) {
            System.out.print("try ");
        } catch (Exception e) { // first is thrown others in the resource close are suppressed
            System.out.print("catch ");
            for (Throwable t : e.getSuppressed()) {
                System.out.println(t.getClass().getName());
            }
        }
    }

    static class MyResource1 implements Closeable {

        @Override
        public void close() throws IOException {
            System.out.print("r1 ");
            throw new IOException("MyResource1");
        }
    }

    static class MyResource2 implements AutoCloseable {
        public void close() throws IOException {
            System.out.print("r2 ");
            throw new IOException("MyResource2");
        }
    }
}
