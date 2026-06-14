class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> uniqueChars = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                else if (uniqueChars.contains(board[i][j])) {
                    // System.out.println(i + ", " + j + ", false at row!");
                    return false;
                } else {
                    uniqueChars.add(board[i][j]);
                }
            }
        }

        for (int j = 0; j < board.length; j++) {
            Set<Character> uniqueChars = new HashSet<>();
            for (int i = 0; i < board[0].length; i++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (uniqueChars.contains(board[i][j])) {
                    // System.out.println(board[i][j] + ", " + uniqueChars);
                    // System.out.println(j + ", " + i + ", false at col!");
                    return false;
                } else {
                    uniqueChars.add(board[i][j]);
                }
            }
        }

        // check 3x3
        Map<String, Set<Character>> uniqueChars = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int boxrow = i / 3;
                int boxcol = j / 3;
                String pos = boxrow + "" + boxcol;
                if (uniqueChars.containsKey(pos)) {
                    if (board[i][j] == '.') continue;
                    else if (uniqueChars.get(pos).contains(board[i][j])) {
                        // System.out.println(i + ", " + j + ", false at box!");
                        return false;
                    } else {
                        uniqueChars.get(pos).add(board[i][j]);
                    }
                } else if (board[i][j] != '.') {
                    Set<Character> boxnums = new HashSet<>();
                    boxnums.add(board[i][j]);
                    uniqueChars.put(pos, boxnums);
                }
            }
        }

        // System.out.println(uniqueChars);

        return true;
    }
}
