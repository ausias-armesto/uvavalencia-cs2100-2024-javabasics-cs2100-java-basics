package recursion;

public class TowerOfHanoi {

    public static int count = 0;

    // Recursive method to solve Tower of Hanoi puzzle
    public static void solveHanoi(int n, char sourceRod, char targetRod, char auxiliaryRod) {
        count++;
        // Base case: If only 1 disk, simply move from source to target
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + sourceRod + " to rod " + targetRod);
            return;
        }

        // Recursive case:
        // Step 1: Move (n-1) disks from source to auxiliary rod using target rod
        solveHanoi(n - 1, sourceRod, auxiliaryRod, targetRod);

        // Step 2: Move the nth disk from source rod to target rod
        System.out.println("Move disk " + n + " from rod " + sourceRod + " to rod " + targetRod);

        // Step 3: Move (n-1) disks from auxiliary rod to target rod using source rod
        solveHanoi(n - 1, auxiliaryRod, targetRod, sourceRod);
    }

    public static void main(String[] args) {
        int numOfDisks = 20; // Integer.parseInt(args[0]); // Set the number of disks
        long startTime = System.nanoTime();
        solveHanoi(numOfDisks, 'A', 'C', 'B'); // 'A' is source, 'C' is target, 'B' is auxiliary
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        // Convert time from nanoseconds to milliseconds for easier readability
        System.out.println("Elapsed Time: " + duration / 1_000_000.0 + " ms");
        System.out.println("Total number of moves: " + count);
    }
}
