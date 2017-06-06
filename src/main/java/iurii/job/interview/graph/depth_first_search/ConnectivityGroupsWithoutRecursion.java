package iurii.job.interview.graph.depth_first_search;

import iurii.job.interview.graph.structure.UnorderedGraph;

public class ConnectivityGroupsWithoutRecursion {
    private int[] connectivityGroups;
    private boolean[] connected;

    public ConnectivityGroupsWithoutRecursion(UnorderedGraph graph) {
        int verticesCount = graph.verticesCount();
        connected = new boolean[verticesCount];
        connectivityGroups = new int[verticesCount];
        for (int i = 0; i < verticesCount; i++) {
            connectivityGroups[i] = Integer.MAX_VALUE;
        }
        int groupNumber = 0;
        for (int i = 0; i < verticesCount; i++) {
            if (!connected[i]) {
                connected[i] = true;
                connectivityGroups[i] = groupNumber;
                DepthFirstSearchWithoutRecursion dfs = new DepthFirstSearchWithoutRecursion(graph, i);
                for (int j = 0; j < verticesCount; j++) {
                    if (dfs.hasPathTo(j)) {
                        connected[j] = true;
                        connectivityGroups[j] = groupNumber;
                    }
                }
                groupNumber++;
            }
        }
    }

    public int groupNumber(int v) {
        return connectivityGroups[v];
    }

    public boolean connected(int v, int w) {
        return connectivityGroups[v] == connectivityGroups[w];
    }

}
