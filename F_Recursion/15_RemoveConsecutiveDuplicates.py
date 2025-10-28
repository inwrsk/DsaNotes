'''
if len of string is less than2 then no chance of having dup so return itself
if greater than 2 the check first two elements
same?
    neglect first char in string and repeat the same process
diff?
    return the first char + func(string after first char)
'''
def removeConsecutiveDuplicates(string):
    if len(string)==0 or len(string)==1:
        return string
    if string[0]==string[1]:
        return removeConsecutiveDuplicates(string[1:])
    return string[0]+removeConsecutiveDuplicates(string[1:])
print(removeConsecutiveDuplicates('Hiii anwaaarrr'))#Hi anwar