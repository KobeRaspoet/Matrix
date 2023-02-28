package Matrix;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatrixTest {

	@Test
	void test() {
		double[] elements1 = {1.2, 2.2, 3.2, 1, 2 ,3};
		double[] elements2 = {1,1,1,1,1,1};
		Matrix m1 = new Matrix(2,3,elements1);
		Matrix m2 = new Matrix(2,3,elements2);
		
		assertEquals(m1.getColumnAmount(), 3);
		assertEquals(m1.getRowAmount(), 2);
		assertEquals(m1.getElement(0,1), 2.2);
		assertArrayEquals(m1.getMatrixColumnMajorOrder(), new double[] {1.2, 1, 2.2, 2, 3.2, 3});
		assertArrayEquals(m1.getMatrixRowMajorOrder(), new double[] {1.2, 2.2, 3.2, 1, 2 ,3});
		assertArrayEquals(m1.getRows(), new double[][] {{1.2, 2.2, 3.2}, {1, 2 ,3}});
		
		Matrix m3 = m1.scaled(1.5);
		assertEquals(m1.getColumnAmount(), 3);
		assertEquals(m1.getRowAmount(), 2);
		assertEquals(m1.getElement(0,1), 2.2);
		assertArrayEquals(m3.getRows(), new double[][] {{1.8, 3.3, 4.8}, {1.5, 3 ,4.5}});
		
		Matrix m4 = m1.plus(m2);
		assertEquals(m1.getColumnAmount(), 3);
		assertEquals(m1.getRowAmount(), 2);
		assertEquals(m1.getElement(0,1), 2.2);
		assertArrayEquals(m4.getRows(), new double[][] {{2.2, 3.2, 4.2}, {2, 3 ,4}});
	}

}
