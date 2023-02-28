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
		
		m1.scale(10);
		assertArrayEquals(m1.getRows(), new double[][] {{12, 22, 32}, {10, 20 , 30}});
		
		m1.add(m2);
		assertArrayEquals(m1.getRows(), new double[][] {{13, 23, 33}, {11, 21 ,31}});
	}

}
