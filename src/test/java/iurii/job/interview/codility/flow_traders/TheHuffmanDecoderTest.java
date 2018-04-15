package iurii.job.interview.codility.flow_traders;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TheHuffmanDecoderTest {

    @Test
    public void test1() {
        Map<String, Character> encodingToCharacter = new HashMap<>();
        encodingToCharacter.put("1110100", '7');
        encodingToCharacter.put("1110101", 'F');
        encodingToCharacter.put("1110110", 'J');
        encodingToCharacter.put("1110111", 'U');
        encodingToCharacter.put("1111000", 'Y');
        encodingToCharacter.put("1111001", 'Z');
        encodingToCharacter.put("1111010", 'z');
        encodingToCharacter.put("1111011", '\n');
        encodingToCharacter.put("1111100", 'Q');
        encodingToCharacter.put("1111101", '5');
        encodingToCharacter.put("1111110", '6');
        encodingToCharacter.put("1111111", '8');
        encodingToCharacter.put("000000", '"');
        encodingToCharacter.put("000001", '4');
        encodingToCharacter.put("000010", 'O');
        encodingToCharacter.put("000011", 'q');
        encodingToCharacter.put("000100", 'x');
        encodingToCharacter.put("000101", '-');
        encodingToCharacter.put("000110", 'K');
        encodingToCharacter.put("000111", '0');
        encodingToCharacter.put("001000", '3');
        encodingToCharacter.put("001001", 'W');
        encodingToCharacter.put("001010", 'E');
        encodingToCharacter.put("001011", 'N');
        encodingToCharacter.put("001100", 'A');
        encodingToCharacter.put("001101", 'V');
        encodingToCharacter.put("001110", '2');
        encodingToCharacter.put("001111", 'M');
        encodingToCharacter.put("010000", 'L');
        encodingToCharacter.put("010001", 'j');
        encodingToCharacter.put("010010", '\'');
        encodingToCharacter.put("010011", '(');
        encodingToCharacter.put("010100", ')');
        encodingToCharacter.put("010101", 'G');
        encodingToCharacter.put("010110", 'P');
        encodingToCharacter.put("010111", 'H');
        encodingToCharacter.put("011000", 'T');
        encodingToCharacter.put("011001", 'C');
        encodingToCharacter.put("011010", 'R');
        encodingToCharacter.put("011011", 'k');
        encodingToCharacter.put("011100", 'B');
        encodingToCharacter.put("011101", 'S');
        encodingToCharacter.put("011110", 'I');
        encodingToCharacter.put("011111", '9');
        encodingToCharacter.put("100000", 'v');
        encodingToCharacter.put("100001", '.');
        encodingToCharacter.put("100010", 'D');
        encodingToCharacter.put("100011", '1');
        encodingToCharacter.put("100100", 'b');
        encodingToCharacter.put("100101", ',');
        encodingToCharacter.put("100110", 'p');
        encodingToCharacter.put("100111", 'y');
        encodingToCharacter.put("101000", 'g');
        encodingToCharacter.put("101001", 'm');
        encodingToCharacter.put("101010", 'f');
        encodingToCharacter.put("101011", 'w');
        encodingToCharacter.put("101100", 'u');
        encodingToCharacter.put("101101", 'c');
        encodingToCharacter.put("101110", 'd');
        encodingToCharacter.put("101111", 'l');
        encodingToCharacter.put("110000", 's');
        encodingToCharacter.put("110001", 'h');
        encodingToCharacter.put("110010", 'r');
        encodingToCharacter.put("110011", 'o');
        encodingToCharacter.put("110100", 'n');
        encodingToCharacter.put("110101", 'i');
        encodingToCharacter.put("110110", 't');
        encodingToCharacter.put("110111", 'a');
        encodingToCharacter.put("111000", 'e');
        encodingToCharacter.put("111001", ' ');
        String decoded = new TheHuffmanDecoder().decode(encodingToCharacter, "011001110111101111101101101100110110110110110111111001010011110100110011101011111001000110110011101111011011110111110110110111010100111001101011110111110000111001110110110001111000111001101101110111100110110101110110110111101111111001110011101010111001011110110100101110110101110111111001101110101100110010110101110100101000111001110110110001111000111001011100110010110101");
        assertThat(decoded).isEqualTo("Calcutta (now Kolkata) was the capital of India during the Br");
    }

    @Test
    public void test2() {
        Map<String, Character> encodingToCharacter = new HashMap<>();
        encodingToCharacter.put("010100", '\n');
        encodingToCharacter.put("010101", '2');
        encodingToCharacter.put("010110", '4');
        encodingToCharacter.put("010111", '9');
        encodingToCharacter.put("011000", ':');
        encodingToCharacter.put("011001", 'G');
        encodingToCharacter.put("011010", 'K');
        encodingToCharacter.put("011011", 'M');
        encodingToCharacter.put("011100", 'V');
        encodingToCharacter.put("011101", 'j');
        encodingToCharacter.put("011110", 'q');
        encodingToCharacter.put("011111", '1');
        encodingToCharacter.put("100000", '6');
        encodingToCharacter.put("100001", 'B');
        encodingToCharacter.put("100010", 'C');
        encodingToCharacter.put("100011", 'I');
        encodingToCharacter.put("100100", 'W');
        encodingToCharacter.put("100101", 'x');
        encodingToCharacter.put("100110", '"');
        encodingToCharacter.put("100111", '5');
        encodingToCharacter.put("101000", '8');
        encodingToCharacter.put("101001", 'E');
        encodingToCharacter.put("101010", 'F');
        encodingToCharacter.put("101011", 'k');
        encodingToCharacter.put("101100", 'R');
        encodingToCharacter.put("101101", 'S');
        encodingToCharacter.put("101110", '0');
        encodingToCharacter.put("101111", 'A');
        encodingToCharacter.put("110000", 'L');
        encodingToCharacter.put("110001", '-');
        encodingToCharacter.put("110010", '.');
        encodingToCharacter.put("110011", ',');
        encodingToCharacter.put("110100", 'v');
        encodingToCharacter.put("110101", 'b');
        encodingToCharacter.put("110110", 'p');
        encodingToCharacter.put("110111", 'g');
        encodingToCharacter.put("111000", 'w');
        encodingToCharacter.put("111001", 'y');
        encodingToCharacter.put("111010", 'm');
        encodingToCharacter.put("111011", 'f');
        encodingToCharacter.put("111100", 'u');
        encodingToCharacter.put("111101", 'c');
        encodingToCharacter.put("111110", 's');
        encodingToCharacter.put("111111", 'h');
        encodingToCharacter.put("00000", 'd');
        encodingToCharacter.put("00001", 'l');
        encodingToCharacter.put("00010", 'r');
        encodingToCharacter.put("00011", 'i');
        encodingToCharacter.put("00100", 'o');
        encodingToCharacter.put("00101", 'a');
        encodingToCharacter.put("00110", 'n');
        encodingToCharacter.put("00111", 't');
        encodingToCharacter.put("01000", 'e');
        encodingToCharacter.put("01001", ' ');
        String decoded = new TheHuffmanDecoder().decode(encodingToCharacter, "1001000001100111111111010010011111111101000010011111010010000001000010010111011011111001000010010010011101101001101100001001110100010100110010010001011110000001010000100100011001100100100111111111010000100101000001010001000001111001010011001110011111111101001111101010000011000111111100000101110011100110100111000000100001100000000100001100100111110101000001011111100100000000010010011100100010011101010100001001001010100111110100101110110000110011100101000010100100101001100000001001001111111110100001001111000001010000100001010000000001");
        assertThat(decoded).isEqualTo("With the collapse of Roman rule in the early 5th century, London ceased to be a capital and the walled");
    }
}
