package iurii.job.interview.aid;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class CrosswordPuzzleTest {

    @Test
    public void testCrosswordIsNull() {
        String match = CrosswordPuzzle.findMatch(Collections.emptyList(), null);
        assertThat(match).isEmpty();
    }

    @Test
    public void testCrosswordIsEmpty() {
        String match = CrosswordPuzzle.findMatch(Collections.emptyList(), "");
        assertThat(match).isEmpty();
    }

    @Test
    public void testCrosswordFound() {
        String match = CrosswordPuzzle
            .findMatch(Arrays.asList(
                "vaporeon",
                "flareon",
                "leafeon",
                "jolteon"
            ), "j......");
        assertThat(match).isEqualTo("jolteon");

        match = CrosswordPuzzle
            .findMatch(Arrays.asList(
                "gandalf",
                "legolas",
                "arwen",
                "bilbo"
            ), "..lb.");
        assertThat(match).isEqualTo("bilbo");

        match = CrosswordPuzzle
            .findMatch(Arrays.asList(
                "harry",
                "draco",
                "hermione",
                "bellatrix"
            ), ".........");
        assertThat(match).isEqualTo("bellatrix");
    }

    @Test
    public void testCrosswordLowercaseFound() {
        String match = CrosswordPuzzle
            .findMatch(Arrays.asList(
                "vaporeon",
                "flareon",
                "leafeon",
                "jolteon"
            ), "J......");
        assertThat(match).isEqualTo("jolteon");

        match = CrosswordPuzzle
            .findMatch(Arrays.asList(
                "gandalf",
                "legolas",
                "arwen",
                "BilBo"
            ), "..Lb.");
        assertThat(match).isEqualTo("bilbo");

    }

    @Test
    public void testCrosswordNotFound() {
        String match = CrosswordPuzzle
            .findMatch(Arrays.asList(
                "vaporeon",
                "flareon",
                "leafeon",
                "jolteon"
            ), "j.b....");
        assertThat(match).isEmpty();
    }

    @Test
    public void leetcodeFindWordPuzzle() {
        assertThat(CrosswordPuzzle.exist(getLeetcodeTestBoard(), "ABCCED")).isTrue();
        assertThat(CrosswordPuzzle.exist(getLeetcodeTestBoard(), "SEE")).isTrue();
        assertThat(CrosswordPuzzle.exist(getLeetcodeTestBoard(), "ABCB")).isFalse();
    }

    private char[][] getLeetcodeTestBoard() {
        return new char[][]{
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
    }

    @Test
    public void hackerrankCrosswordPuzzle() {
        String[] crossword = {
            "+-++++++++",
            "+-++++++++",
            "+-++++++++",
            "+-----++++",
            "+-+++-++++",
            "+-+++-++++",
            "+++++-++++",
            "++------++",
            "+++++-++++",
            "+++++-++++"
        };
        String words = "LONDON;DELHI;ICELAND;ANKARA";
        String[] answer = CrosswordPuzzle.crosswordPuzzle(crossword, words);
        assertThat(answer)
            .isEqualTo(
                new String[]{
                    "+L++++++++",
                    "+O++++++++",
                    "+N++++++++",
                    "+DELHI++++",
                    "+O+++C++++",
                    "+N+++E++++",
                    "+++++L++++",
                    "++ANKARA++",
                    "+++++N++++",
                    "+++++D++++"
                }
            );

        String[] crossword1 = {
            "+-++++++++",
            "+-++++++++",
            "+-------++",
            "+-++++++++",
            "+-++++++++",
            "+------+++",
            "+-+++-++++",
            "+++++-++++",
            "+++++-++++",
            "++++++++++"
        };
        String words1 = "AGRA;NORWAY;ENGLAND;GWALIOR";
        String[] answer1 = CrosswordPuzzle.crosswordPuzzle(crossword1, words1);
        assertThat(answer1)
            .isEqualTo(
                new String[]{
                    "+E++++++++",
                    "+N++++++++",
                    "+GWALIOR++",
                    "+L++++++++",
                    "+A++++++++",
                    "+NORWAY+++",
                    "+D+++G++++",
                    "+++++R++++",
                    "+++++A++++",
                    "++++++++++"
                }
            );

        String[] crossword2 = {
            "++++++-+++",
            "++------++",
            "++++++-+++",
            "++++++-+++",
            "+++------+",
            "++++++-+-+",
            "++++++-+-+",
            "++++++++-+",
            "++++++++-+",
            "++++++++-+"
        };
        String words2 = "ICELAND;MEXICO;PANAMA;ALMATY";
        String[] answer2 = CrosswordPuzzle.crosswordPuzzle(crossword2, words2);
        assertThat(answer2)
            .isEqualTo(
                new String[]{
                    "++++++I+++",
                    "++MEXICO++",
                    "++++++E+++",
                    "++++++L+++",
                    "+++PANAMA+",
                    "++++++N+L+",
                    "++++++D+M+",
                    "++++++++A+",
                    "++++++++T+",
                    "++++++++Y+"
                }
            );
    }
}