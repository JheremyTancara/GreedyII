#include <iostream>
#include <vector>
#include <algorithm>
#include <chrono>

using namespace std;
using namespace chrono;

int main() {
    auto start_time = high_resolution_clock::now();

    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int t;
    cin >> t;

    while (t--) {
        int M;
        cin >> M;

        vector<pair<int, int>> coordinates;
        int l, r;

        while (true) {
            cin >> l >> r;
            if (l == 0 && r == 0) {
                break;
            }
            coordinates.push_back({l, r});
        }

        sort(coordinates.begin(), coordinates.end());

        vector<pair<int, int>> ans;
        int current = 0, i = 0;

        while (current < M && i < coordinates.size()) {
            int maxR = -1, index = -1;

            while (i < coordinates.size() && coordinates[i].first <= current) {
                if (coordinates[i].second > maxR) {
                    maxR = coordinates[i].second;
                    index = i;
                }
                i++;
            }

            if (index == -1) {
                break;
            }

            ans.push_back(coordinates[index]);
            current = maxR;
        }

        if (current < M) {
            cout << 0 << endl;
        } else {
            cout << ans.size() << endl;
            for (const auto& p : ans) {
                cout << p.first << " " << p.second << endl;
            }
        }

        if (t > 0) {
            cout << endl;
        }
    }
    auto end_time = high_resolution_clock::now();
    auto duration = duration_cast<nanoseconds>(end_time - start_time);

    cout << "Tiempo de ejecución: " << duration.count() << " milisegundos" << endl;

    return 0;
}
