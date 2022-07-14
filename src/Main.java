import LvlA.LvlA;
import LvlB.MainWin;
import LvlC.MainFrame;
import LvlD.MainFrameD;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please choose level to run:\n1.Level A\n2.Level B\n3.Level C\n4.Level D");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice){
            case 1: {
                initLvlA();
                break;
            }
            case 2: {
                initLvlB();
                break;
            }
            case 3: {
                initLvlC();
                break;
            }
            case 4: {
                initLvlD();
                break;
            }
            default: {
                System.out.println("Invalid input, please try again");
                break;
            }

        }
    }

    private static void initLvlD() {
        new MainFrameD();
    }

    private static void initLvlC() {
        new MainFrame();
    }

    private static void initLvlB() {
        MainWin ex = new MainWin("Minesweeper(B)");
        ex.setVisible(true);
    }

    static void initLvlA(){
        LvlA st = new LvlA();
        st.play();
    }
}
