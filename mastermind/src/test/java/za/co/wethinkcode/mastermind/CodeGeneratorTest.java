package za.co.wethinkcode.mastermind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CodeGeneratorTest {

    @Test
    public void testGenerateCodeLength(){
        CodeGenerator codeGenerator = new CodeGenerator();
        assertEquals(4, codeGenerator.generateCode().length());
    }

    @Test
    public void testGenerateCodeRange(){

        CodeGenerator codeGenerator = new CodeGenerator();
        String[] codeList = codeGenerator.generateCode().split("");

        for(int i = 0; i < 4; i++){
                assertTrue(Integer.parseInt(codeList[i]) > 0 && Integer.parseInt(codeList[i]) < 9);
            }
        }
    }