package movezeroes

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestMoveZeroes(t *testing.T) {
	tests := []struct {
		title    string
		input    []int
		expected []int
	}{
		{
			title:    "Example 1",
			input:    []int{0, 1, 0, 3, 12},
			expected: []int{1, 3, 12, 0, 0},
		},
		{
			title:    "Example 2",
			input:    []int{0},
			expected: []int{0},
		},
	}

	for _, test := range tests {
		t.Run(test.title, func(t *testing.T) {
			nums := append([]int(nil), test.input...)
			moveZeroes(nums)
			assert.Equal(t, test.expected, nums)
		})
	}
}
