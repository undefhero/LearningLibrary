package twosumsorted

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestTwoSum(t *testing.T) {
	testCases := []struct {
		nums     []int
		target   int
		expected []int
	}{
		{
			nums:     []int{2, 7, 11, 15},
			target:   9,
			expected: []int{1, 2},
		},
	}

	for _, test := range testCases {
		result := twoSum(test.nums, test.target)
		assert.Equal(t, test.expected, result)
	}
}
