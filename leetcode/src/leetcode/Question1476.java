package leetcode;

/**
 * 请你实现一个类SubrectangleQueries，它的构造函数的参数是一个 rows x cols的矩形（这里用整数矩阵表示），并支持以下两种操作：
 * 1.updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 * 用newValue更新以(row1,col1)为左上角且以(row2,col2)为右下角的子矩形。
 * 2.getValue(int row, int col)
 * 返回矩形中坐标 (row,col) 的当前值。
 *
 * @Author wushaoya
 * @date 2023-07-10
 * Time: 11:00
 */
public class Question1476 {
    public static void main(String[] args) {
        int[][] rectangle = {{1,2,1}, {4,3,4},{3,2,1},{1,1,1}};
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(rectangle);
        subrectangleQueries.getValue(0,2);
        subrectangleQueries.updateSubrectangle(0,0,3,2,5);
        subrectangleQueries.getValue(0,2);
    }
}

class SubrectangleQueries {
    int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[0].length; j++) {
                if (i >= row1 && i <= row2 && j >= col1 && j <= col2) {
                    this.rectangle[i][j] = newValue;
                }
            }
        }
    }

    public int getValue(int row, int col) {
        return this.rectangle[row][col];
    }
}
