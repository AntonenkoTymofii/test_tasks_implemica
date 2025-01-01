package org.example;

import java.util.*;

public class Main {
    static class City {
        String name; // Name of the city
        List<Edge> neighbors = new ArrayList<>(); // List of neighboring cities
    }

    static class Edge {
        int target; // Index of the neighboring city
        int cost;   // Transportation cost to the neighbor

        Edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        int tests = scanner.nextInt();

        while (tests-- > 0) {
            // Read the number of cities
            int n = scanner.nextInt();

            // Map to store city names and their indices
            Map<String, Integer> cityIndex = new HashMap<>();

            // Array to store city objects
            City[] cities = new City[n];

            for (int i = 0; i < n; i++) {
                cities[i] = new City();

                // Read the name of the city
                cities[i].name = scanner.next();
                cityIndex.put(cities[i].name, i);

                // Read the number of neighbors
                int p = scanner.nextInt();

                // Read the neighbors and their transportation costs
                for (int j = 0; j < p; j++) {
                    int neighborIndex = scanner.nextInt() - 1;
                    int cost = scanner.nextInt();
                    cities[i].neighbors.add(new Edge(neighborIndex, cost));
                }
            }

            // Read the number of paths to compute
            int r = scanner.nextInt();

            for (int i = 0; i < r; i++) {
                // Read the source and destination cities
                String source = scanner.next();
                String destination = scanner.next();

                // Find the minimum cost using Dijkstra's algorithm
                int result = dijkstra(cities, cityIndex.get(source), cityIndex.get(destination));

                // Print the minimum cost
                System.out.println(result);
            }
        }
    }

    // Dijkstra's algorithm to find the shortest path between two cities
    private static int dijkstra(City[] cities, int src, int dest) {
        // Array to store the minimum distance to each city
        int[] distances = new int[cities.length];
        Arrays.fill(distances, Integer.MAX_VALUE); // Initialize with "infinity"
        distances[src] = 0; // Distance to the source city is 0

        // Priority queue to process cities based on the minimum cost
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        pq.offer(new Edge(src, 0));

        while (!pq.isEmpty()) {
            // Get the city with the smallest cost
            Edge current = pq.poll();
            int currentCity = current.target;

            // Skip if the current cost is greater than the known minimum distance
            if (current.cost > distances[currentCity]) continue;

            // Update distances to neighbors
            for (Edge edge : cities[currentCity].neighbors) {
                int newDist = distances[currentCity] + edge.cost;
                if (newDist < distances[edge.target]) {
                    distances[edge.target] = newDist;
                    pq.offer(new Edge(edge.target, newDist));
                }
            }
        }

        // Return the distance to the destination city
        return distances[dest];
    }
}