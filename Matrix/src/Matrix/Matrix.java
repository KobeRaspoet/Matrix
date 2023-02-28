package Matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * an immutable object Matrix which stores a matrix
 * @immutable
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
	 * @inspects | this
	 * @post | result != null
	 * @post | result.getRowAmount() == getRowAmount()
	 * @post | result.getColumnAmount() == getColumnAmount()
	 * @post | IntStream.range(0,getRowAmount()).allMatch(i ->
	 * 		 | 	IntStream.range(0,getColumnAmount()).allMatch(j ->
	 * 		 |		result.getElement(i,j) == getElement(i,j)*alfa
	 * 	     |	)
	 * 		 |)
	 * @creates | result
	 * 
	 */
	public Matrix scaled(double alfa) {throw new RuntimeException("not yet implemented");}
	
	/**
	 * @inspects | this, other
	 * @pre | other != null
	 * @pre | getRowAmount() == other.getRowAmount()
	 * @pre | getColumnAmount() == other.getColumnAmount()
	 * @creates | result
	 * @post | result != null
	 * @post | result.getRowAmount() == getRowAmount()
	 * @post | result.getColumnAmount() == getColumnAmount()
	 * @post | IntStream.range(0,getRowAmount()).allMatch(i ->
	 * 		 | 	IntStream.range(0,getColumnAmount()).allMatch(j ->
	 * 		 |		result.getElement(i,j) == getElement(i,j)+other.getElement(i,j)
	 * 	     |	)
	 * 		 |)
	 */
	public Matrix plus(Matrix other) {throw new RuntimeException("not yet implemented");}
}
