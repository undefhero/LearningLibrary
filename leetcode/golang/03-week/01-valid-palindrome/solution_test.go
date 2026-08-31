package validpalindrome

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestPalindrome(t *testing.T) {
	tests := []struct {
		title    string
		input    string
		expected bool
	}{
		{
			title:    "Positive",
			input:    "A man, a plan, a canal: Panama",
			expected: true,
		},
		{
			title:    "Negative",
			input:    "race a car",
			expected: false,
		},
		{
			title:    "Positive Empty",
			input:    " ",
			expected: true,
		},
	}

	for _, test := range tests {
		t.Run(test.title, func(t *testing.T) {
			assert.Equal(t, test.expected, isPalindrome(test.input))
		})
	}
}
