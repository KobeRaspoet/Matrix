package Matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * an mutates object Matrix which acts as a matrix
 * @invar | getRowAmount() >= 0
 * @invar | getColumnAmount() >= 0
 * @invar | getMatrixRowMajorOrder() != null
 * @invar | getMatrixColumnMajorOrder() != null
 * @invar | getRows() != null
 * @invar | Arrays.stream(getRows()).allMatch(row -> row != null && row.length == getColumnAmount())
 */
public class Matrix {
	
	
	
	/**
	 * @inspects | this
	 */
	public int getRowAmount() {throw new RuntimeException("not yet implemented");}
	
	/**
	 * @inspects | this
	 */
	public int getColumnAmount() {throw new RuntimeException("not yet implemented");}
	
	/**
	 * @creates | result, ...result
	 * @post | result.length == getRowAmount()
	 */
	public double[][] getRows() {throw new RuntimeException("not yet implemented");}
	
	/**
	 * @pre | 0 <= rowIndex && rowIndex < getRowAmount()
	 * @pre | 0 <= columnIndex && columnIndex < getRowAmount()
	 * @inspects | this
	 * @post | result == getRows()[rowIndex][columnIndex]
	 */
	public double getElement(int rowIndex, int columnIndex) {throw new RuntimeException("not yet implemented");}
	
	/**
	 * @creates | result
	 * @post | result.length == getRowAmount() * getColumnAmount()
	 * @post | result != null
	 * @post | IntStream.range(0,getRowAmount()).allMatch(i ->
	 * 		 | 	IntStream.range(0,getColumnAmount()).allMatch(j ->
	 * 		 |		result[i*getColumnAmount() + j] == getRows()[i][j]
	 * 	     |	)
	 * 		 |)
	 */
	public double[] getMatrixRowMajorOrder() {throw new RuntimeException("not yet implemented");}
	
	/**
	 * @creates | result
	 * @post | result.length == getRowAmount() * getColumnAmount()
	 * @post | result != null
	 * @post | IntStream.range(0,getRowAmount()).allMatch(i ->
	 * 		 | 	IntStream.range(0,getColumnAmount()).allMatch(j ->
	 * 		 |		result[j*getRowAmount() + i] == getRows()[i][j]
	 * 	     |	)
	 * 		 |)
	 */
	public double[] getMatrixColumnMajorOrder() {throw new RuntimeException("not yet implemented");}
	

	
	/**
	 * elements is ordered in RowMajorOrder way
	 * @throws IllegalArgumentException | rows < 0
	 * @throws IllegalArgumentException | columns < 0
	 * @throws IllegalArgumentException | elements == null
	 * @throws IllegalArgumentException | elements.length != rows * columns
	 * @inspects | elements
	 * @post | getRowAmount() == rows
	 * @post | getColumnAmount() == columns
	 * @post | Arrays.equals(elements, getMatrixRowMajorOrder())
	 */
	public Matrix(int rows, int columns, double[] elements) {throw new RuntimeException("not yet implemented");}
	
	/**
	 * @mutates | this
	 * @post | this != null
	 * @post | old(this).getRowAmount() == getRowAmount()
	 * @post | old(this).getColumnAmount() == getColumnAmount()
	 * @post | IntStream.range(0,getRowAmount()).allMatch(i ->
	 * 		 | 	IntStream.range(0,getColumnAmount()).allMatch(j ->
	 * 		 |		getElement(i,j) == old(this).getElement(i,j)*alfa
	 * 	     |	)
	 * 		 |)
	 */
	public void scale(double alfa) {throw new RuntimeException("not yet implemented");}
	
	/**
	 * @mutates | this
	 * @inspects | this
	 * @pre | other != null
	 * @pre | getRowAmount() == other.getRowAmount()
	 * @pre | getColumnAmount() == other.getColumnAmount()
	 * @post | this != null
	 * @post | getRowAmount() == old(this).getRowAmount()
	 * @post | getColumnAmount() == old(this).getColumnAmount()
	 * @post | IntStream.range(0,getRowAmount()).allMatch(i ->
	 * 		 | 	IntStream.range(0,getColumnAmount()).allMatch(j ->
	 * 		 |		getElement(i,j) == old(this).getElement(i,j)+other.getElement(i,j)
	 * 	     |	)
	 * 		 |)
	 */
	public void add(Matrix other) {throw new RuntimeException("not yet implemented");}
}
