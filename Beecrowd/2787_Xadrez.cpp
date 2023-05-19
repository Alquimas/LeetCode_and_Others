#include <iostream>
 
using namespace std;
 
int main() {
    int L, C;
    cin >> L;
    cin >> C;
    
    cout << (C%2 + L%2 + 1)%2 << endl;
    return 0;
}
