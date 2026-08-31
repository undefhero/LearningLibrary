package movezeroes

func moveZeroes(nums []int) {
	if len(nums) > 1 {
		left := 0

		for right := range len(nums) {
			if nums[right] != 0 {
				nums[right], nums[left] = nums[left], nums[right]
				left++
			}
		}
	}
}
