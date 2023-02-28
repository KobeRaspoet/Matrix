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
	 * @invar | rowCount >= 0
	 * @invar | columnCount >= 0
	 * @invar | elementsRMO != null
	 * @invar | elementsRMO.length == rowCount*columnCount
	 */
	private int rowCount;
	private int columnCount;
	/**
	 * @representationObject
	 */
	private double[] elementsRMO;
	
	/**
	 * @inspects | this
	 */
	public int getRowAmount() {return rowCount;}
	
	/**
	 * @inspects | this
	 */
	public int getColumnAmount() {return columnCount;}
	
	/**
	 * @creates | result, ...result
	 * @post | result.length == getRowAmount()
	 */
	public double[][] getRows() {
		double[][] result = new double[rowCount][columnCount];
		for(int i = 0; i < rowCount ; i++) {
			for(int j = 0 ; j < columnCount ; j++) {
				result[i][j] = elementsRMO[i * columnCount + j];
			}
		}
		return result;
	}
	
	/**
	 * @pre | 0 <= rowIndex && rowIndex < getRowAmount()
	 * @pre | 0 <= columnIndex && columnIndex < getColumnAmount()
	 * @inspects | this
	 * @post | result == getRows()[rowIndex][columnIndex]
	 */
	public double getElement(int rowIndex, int columnIndex) {
		return elementsRMO[rowIndex * columnCount + columnIndex];
	}
	
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
	public double[] getMatrixRowMajorOrder() {
		return elementsRMO.clone();
	}
	
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
	public double[] getMatrixColumnMajorOrder() {
		double[] result = new double[rowCount*columnCount];
		for(int i = 0; i < rowCount ; i++) {
			for(int j = 0 ; j < columnCount ; j++) {
				result[j*rowCount + i] = elementsRMO[i*columnCount + j]; 
			}
		}
		return result;
	}
	

	
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
	public Matrix(int rows, int columns, double[] elements) {
		this.rowCount = rows;
		this.columnCount = columns;
		this.elementsRMO = elements.clone();
	}
	
	/**
	 * @mutates | this
	 * @post | this != null
	 * @post | old(getRowAmount()) == getRowAmount()
	 * @post | old(getColumnAmount()) == getColumnAmount()
	 * @post | IntStream.range(0,getRowAmount()).allMatch(i ->
	 * 		 | 	IntStream.range(0,getColumnAmount()).allMatch(j ->
	 * 		 |		this.getElement(i,j) == old(getRows())[i][j]*alfa
	 * 	     |	)
	 * 		 |)
	 */
	public void scale(double alfa) {
		for(int i = 0; i < rowCount*columnCount; i++)
			this.elementsRMO[i] = elementsRMO[i] * alfa;
	}
	
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
	 * 		 |		getElement(i,j) == old(getRows())[i][j]+other.getElement(i,j)
	 * 	     |	)
	 * 		 |)
	 */
	public void add(Matrix other) {
		double[] elementsOther = other.getMatrixRowMajorOrder();
		for(int i = 0; i < rowCount*columnCount; i++)
			elementsRMO[i] += elementsOther[i];
	}
}
