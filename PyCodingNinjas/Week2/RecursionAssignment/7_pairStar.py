#seperates the string by '*' in the middle of same adjacent char's
def pairStar(string):
    if len(string)<=1:
        return string
    if string[0]==string[1]:
        return string[0]+'*'+pairStar(string[1:])
    else:
        return string[0]+pairStar(string[1:])
print(pairStar('hello'))#hel*lo