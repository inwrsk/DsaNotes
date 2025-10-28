def StrToInt(string):
    if len(string)==1:
        return string[0]
    else:
        if string[0]=='0':
            return ''+StrToInt(string[1:])
        return string
print(StrToInt('00023200423000'))#23200423000