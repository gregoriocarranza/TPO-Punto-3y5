import model.DynamicDictionary;
import model.DynamicStack;
import utils.DictionaryUtil;
import utils.StackUtils;

public class Main {
    public static void main(String[] args) {
        DynamicStack stack = new DynamicStack();
        stack.add(3);
        stack.add(1);
        stack.add(4);
        stack.add(2);
        stack.add(3);
        stack.add(2);
        stack.add(9);

        DynamicStack processedStack = StackUtils.OrderStack(stack);

        System.out.println("--------------------------Ejercicio 5 Parte 1--------------------------\n");
        System.out.println("Pila sin duplicados y ordenada:");
        while (!processedStack.isEmpty()) {
            System.out.println(processedStack.getTop());
            processedStack.remove();
        }
        System.out.println("\n");
        System.out.println("--------------------------Ejercicio 5 Parte 2--------------------------\n");
        String Text = "Hvwh hv xp whawr gh suxhed frp oáv gh txlplhpwrv fdudfwhuhv sdud dsñlfdu hñ fliudgr Févdu b ñxhjr lpwhpwdu ghvhpfulswduñr xvdpgr ñd iuhfxhpfld gh ñhwudv hp hvsdqrñ.";

        String decryptedText = DictionaryUtil.decryptCesar(Text);
        System.out.println("Texto descifrado: " + decryptedText);

        System.out.println("\n");
        System.out.println("--------------------------Ejercicio 5 Parte 3--------------------------\n");

        String testExpression = "{( 'text )}')}";
        System.out.println("¿Está balanceado? " + DictionaryUtil.isBalanced(testExpression));
    }
}
