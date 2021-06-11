class Solution {
    public Node cloneGraph(Node node) {

        if (node == null){
            return null;
        }

        Deque<Node> queue = new ArrayDeque<>();
        Map<Node, Node> map = new HashMap<>();

        Node clone = new Node(node.val);

        map.put(node, clone);

        queue.offer(node);

        while (!queue.isEmpty()){
            Node curr = queue.poll();

            for (Node neighbor : curr.neighbors){
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }

                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }



        return clone;

    }
}
