package mergeintervals

import "sort"

func merge(intervals [][]int) [][]int {
	if len(intervals) == 0 {
		return [][]int{}
	}

	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	res := [][]int{intervals[0]}

	for _, value := range intervals[1:] {
		last := res[len(res)-1]

		if value[0] <= last[1] {
			res[len(res)-1] = []int{min(last[0], value[1]), max(last[1], value[1])}
		} else {
			res = append(res, value)
		}
	}

	return res
}
