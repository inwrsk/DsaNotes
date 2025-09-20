def binarySearch(arr, key):
    p=0
    q=len(arr)-1
    while p<=q :
        mid = (p+q)//2
        if key == arr[mid]:
            return "Your Element is found at index : ", mid
        elif key<arr[mid]:
            q=mid-1
            continue
        p=mid+1
    return "Oops! Element not found"
arr = [ int(i) for i in input("Enter sorted array elements : ").split() ]
key = int(input("Enter key : "))
print(binarySearch(arr, key))
