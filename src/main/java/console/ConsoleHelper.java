package console;

public class ConsoleHelper {

    public void consoleMessage(){

    }

//    private static final BufferedReader bufferedReader;
//
//    public ConsoleHelper() {
//    }
//
//    public static void writeMessage(String message) {
//        System.out.println(message);
//    }
//
//    public static String readString() throws IOException {
//        return bufferedReader.readLine();
//    }
//
//    public static List<Dish> getAllDishesForOrder() throws IOException {
//        ArrayList dishes = new ArrayList();
//        writeMessage("Choose dish " + Dish.allDishesToString());
//
//        while(true) {
//            String dish = readString();
//            if(dish.equals("exit")) {
//                return dishes;
//            }
//
//            try {
//                dishes.addMenu(Dish.valueOf(dish));
//            } catch (IllegalArgumentException var3) {
//                writeMessage(dish + " is not detected");
//            }
//        }
//    }
//
//    static {
//        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    }
}
