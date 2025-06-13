class Solution {
    public int[] solution(String[] park, String[] routes) {
        int rows = park.length;
        int cols = park[0].length();
        int startX = 0, startY = 0;

       // start index
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (park[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }

        int[][] directionMap = {
            {1, 0},  // S
            {-1, 0}, // N
            {0, 1},  // E
            {0, -1}  // W
        };

        for (String route : routes) {
            String[] parts = route.split(" ");
            char dir = parts[0].charAt(0);
            int dist = Integer.parseInt(parts[1]);

            int dx = 0, dy = 0;
            switch (dir) {
                case 'S': dx = directionMap[0][0]; dy = directionMap[0][1]; break;
                case 'N': dx = directionMap[1][0]; dy = directionMap[1][1]; break;
                case 'E': dx = directionMap[2][0]; dy = directionMap[2][1]; break;
                case 'W': dx = directionMap[3][0]; dy = directionMap[3][1]; break;
            }

            boolean valid = true;
            int nx = startX;
            int ny = startY;

            for (int i = 1; i <= dist; i++) {
                int tx = startX + dx * i;
                int ty = startY + dy * i;

                if (tx < 0 || tx >= rows || ty < 0 || ty >= cols || park[tx].charAt(ty) == 'X') {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                startX += dx * dist;
                startY += dy * dist;
            }
        }

        return new int[]{startX, startY};
    }
}
