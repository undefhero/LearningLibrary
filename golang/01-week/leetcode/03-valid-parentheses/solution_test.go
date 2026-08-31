package validparentheses

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestIsValid(t *testing.T) {
	assert.True(t, isValid("()"))
	assert.True(t, isValid("()[]{}"))
	assert.False(t, isValid("(]"))
	assert.False(t, isValid("([)]"))
	assert.True(t, isValid("{[]}"))
	assert.False(t, isValid("{"))
}
