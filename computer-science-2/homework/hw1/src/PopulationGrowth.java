public class PopulationGrowth {
    public static void main(String[] args){
        if(args.length != 3) {
            System.out.println("Invalid arguments. Enter in the form of int double int");
            System.exit(0);
        }

        int initial = Integer.parseInt(args[0]);
        double growthRate = Double.parseDouble(args[1]) / 100;
        int time = Integer.parseInt(args[2]);

        System.out.println("Elapsed Years        Amount");
        System.out.println("---------------------------");
        for(int i = 0; i <= time; i++){
            // use printf to format, and calculate population growth at time i
            // use if statement to control break in the table
            if(i < 4 || i == time) {
                System.out.printf("%2d                    %d%n", i, (int) (initial * Math.exp(growthRate * i)));
            }else if(i == 4){
                System.out.println("...");
            }
        }
    }
}
