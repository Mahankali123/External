import java.util.Scanner;

public class DistanceVector {
    private int numNodes;
    private int[][] costMatrix;
    private int[][] routingTable;

    public DistanceVector(int numNodes) {
        this.numNodes = numNodes;
        this.costMatrix = new int[numNodes][numNodes];
        this.routingTable = new int[numNodes][numNodes];
    }   

    public void takeInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the cost matrix for the network:");

        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                System.out.print("Cost from Node " + i + " to Node " + j + ": ");
                costMatrix[i][j] = scanner.nextInt();
            }
        }
    }

    public void initializeRoutingTable() {
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                if (i == j) {
                    routingTable[i][j] = 0;
                } else {
                    routingTable[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public void updateRoutingTable() {
        boolean updated;

        do {
            updated = false;

            for (int i = 0; i < numNodes; i++) {
                for (int j = 0; j < numNodes; j++) {
                    for (int k = 0; k < numNodes; k++) {
                        if (costMatrix[i][k] != Integer.MAX_VALUE && routingTable[k][j] != Integer.MAX_VALUE) {
                            int newCost = costMatrix[i][k] + routingTable[k][j];
                            if (newCost < routingTable[i][j]) {
                                routingTable[i][j] = newCost;
                                updated = true;
                            }
                        }
                    }
                }
            }
        } while (updated);
    }

    public void displayRoutingTable() {
        System.out.println("Routing Tables:");
        for (int i = 0; i < numNodes; i++) {
            System.out.println("\nRouting table for Node " + i + ":");
            System.out.println("To\tCost");
            for (int j = 0; j < numNodes; j++) {
                if (i != j) {
                    System.out.println(j + "\t" + routingTable[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes in the network: ");
        int numNodes = scanner.nextInt();

        DistanceVector router = new DistanceVector(numNodes);
        router.takeInput();
        router.initializeRoutingTable();
        router.updateRoutingTable();
        router.displayRoutingTable();
    }
}