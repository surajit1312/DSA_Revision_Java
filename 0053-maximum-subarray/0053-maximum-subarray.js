/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
  let max = -Infinity;
  let currentSum = 0;
  let areAllNegative = true;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] >= 0) {
      areAllNegative = false;
      break;
    }
  }
  if (areAllNegative) {
    for (let i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        max = nums[i];
      }
    }
  } else {
    for (let i = 0; i < nums.length; i++) {
      currentSum += nums[i];
      if (currentSum < 0) {
        currentSum = 0;
      }
      if (currentSum > max) {
        max = currentSum;
      }
    }
  }
  return max;
};