

import org.example.Solution3;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * 测试用例设计原则：
 * 1. 等价类划分：
 * - 正常输入：数组中包含多个满足整除关系的数字
 * - 边界输入：数组长度为1或所有数字均为素数（无整除关系）
 * - 异常输入：空数组或 null
 * 2. 特殊情况：
 * - 数组中所有数字可以整除成链
 * - 数组中没有任何数字可以整除成链
 */
public class L2022111312_3_Test {

    /**
     * 测试目的：验证当输入包含多个满足整除关系的数字时，算法能够正确找到最大整除子集
     * 测试用例：
     * nums = [1, 2, 4, 8]
     * 预期结果：[1, 2, 4, 8]
     */
    @Test
    public void testNormalCase() {
        Solution3 solution = new Solution3();
        int[] nums = {1, 2, 4, 8};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        assertTrue(result.containsAll(List.of(1, 2, 4, 8)));
    }

    /**
     * 测试目的：验证当数组长度为1时，返回唯一元素
     * 测试用例：
     * nums = [10]
     * 预期结果：[10]
     */
    @Test
    public void testSingleElement() {
        Solution3 solution = new Solution3();
        int[] nums = {10};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        assertEquals(List.of(10), result);
    }

    /**
     * 测试目的：验证当输入数组为空时，返回空列表
     * 测试用例：
     * nums = []
     * 预期结果：[]
     */
    @Test
    public void testEmptyArray() {
        Solution3 solution = new Solution3();
        int[] nums = {};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        assertTrue(result.isEmpty());
    }

    /**
     * 测试目的：验证当输入数组中没有数字可以整除时，返回单个数字
     * 测试用例：
     * nums = [3, 5, 7]
     * 预期结果：[任意单个数字]
     */
    @Test
    public void testNoDivisibleSubset() {
        Solution3 solution = new Solution3();
        int[] nums = {3, 5, 7};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        assertEquals(3, result.size());
        assertTrue(List.of(3, 5, 7).contains(result.get(0)));
    }

    /**
     * 测试目的：验证算法对所有数字都能形成链的情况
     * 测试用例：
     * nums = [1, 2, 3, 6]
     * 预期结果：[1, 2, 6] 或 [1, 3, 6]
     */
    @Test
    public void testFullChainCase() {
        Solution3 solution = new Solution3();
        int[] nums = {1, 2, 3, 6};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        assertTrue(result.containsAll(List.of(1, 6)));
    }
}