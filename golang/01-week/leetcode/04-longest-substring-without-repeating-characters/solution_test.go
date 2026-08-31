package longestsubstringwithoutrepeatingcharacters

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestLengthOfLongestSubstring(t *testing.T) {
	assert.Equal(t, 1, lengthOfLongestSubstring(" "))
}
