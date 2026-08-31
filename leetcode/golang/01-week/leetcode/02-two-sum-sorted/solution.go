package twosumsorted

func twoSum(nums []int, target int) []int {
	start := 0
	end := len(nums) - 1

	for start < end {
		sum := nums[start] + nums[end]

		if sum == target {
			return []int{start + 1, end + 1}
		} else if sum < target {
			start++
		} else {
			end--
		}
	}

	return nil
}

// func main() {
// 	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9))
// }
