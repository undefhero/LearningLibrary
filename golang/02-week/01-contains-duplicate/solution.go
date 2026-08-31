package containsduplicate

func containsDuplicate(nums []int) bool {
	seen := make(map[int]bool, len(nums))

	for _, num := range nums {
		if seen[num] {
			return true
		}

		seen[num] = true
	}

	return false
}
