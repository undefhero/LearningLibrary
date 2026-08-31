package validanagram

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestIsAnagram(t *testing.T) {
	assert.True(t, isAnagram("anagram", "nagaram"))
}

func TestIsAnagramDifferentLetters(t *testing.T) {
	assert.False(t, isAnagram("rat", "car"))
}
