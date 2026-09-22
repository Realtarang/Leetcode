class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] ind = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++)
            ind[prerequisites[i][0]]++;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < ind.length; i++) {
            if (ind[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int it : adj.get(node)) {
                ind[it]--;
                if (ind[it] == 0) {
                    q.offer(it);
                }
            }
        }
        if (count != numCourses) {
            return false;
        }
        return true;
    }
}