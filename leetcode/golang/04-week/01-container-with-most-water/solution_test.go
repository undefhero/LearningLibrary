package containerwithmostwater

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestWaterArea(t *testing.T) {
	tests := []struct {
		title    string
		input    []int
		expected int
	}{
		{
			title:    "Example 1",
			input:    []int{1, 8, 6, 2, 5, 4, 8, 3, 7},
			expected: 49,
		},
		{
			title:    "Example 2",
			input:    []int{1, 1},
			expected: 1,
		},
	}

	for _, test := range tests {
		t.Run(test.title, func(t *testing.T) {
			assert.Equal(t, test.expected, maxArea(test.input))
		})
	}
}
