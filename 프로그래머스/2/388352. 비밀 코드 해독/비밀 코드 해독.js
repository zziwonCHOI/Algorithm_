function solution(n, q, ans) {
  let count = 0;
  const m = q.length;

  for (let a = 1; a <= n - 4; a++) {
    for (let b = a + 1; b <= n - 3; b++) {
      for (let c = b + 1; c <= n - 2; c++) {
        for (let d = c + 1; d <= n - 1; d++) {
          for (let e = d + 1; e <= n; e++) {
            const candidate = [a, b, c, d, e];

            let ok = true;

            for (let i = 0; i < m; i++) {
              let match = 0;

              for (let x of candidate) {
                if (q[i].includes(x)) {
                  match++;
                }
              }

              if (match !== ans[i]) {
                ok = false;
                break;
              }
            }

            if (ok) count++;
          }
        }
      }
    }
  }

  return count;
}
