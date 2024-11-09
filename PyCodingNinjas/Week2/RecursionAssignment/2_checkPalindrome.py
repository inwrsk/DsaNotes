def isPalindrome(string):
    if len(string)<=1:
        return True
    else:
        return string[0]==string[-1] and isPalindrome(string[1:-1]) 
print(isPalindrome('racecar'))#True