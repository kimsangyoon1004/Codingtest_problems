class Solution {
    public int[] solution(String[] wallpaper) {
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i + 1);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j + 1);
                }
            }
        }

        return new int[]{minRow, minCol, maxRow, maxCol};
    }
}
