function solution(players, m, k) {
  const HOURS = 24;

  // 각 시간에 반납될 서버 수
  const release = Array(HOURS + k + 1).fill(0);

  let active = 0; // 현재 운영 중인 서버 수
  let answer = 0;

  for (let i = 0; i < HOURS; i++) {
    // 1. 서버 반납
    active -= release[i];

    // 2. 현재 시간에 필요한 서버 수
    const need = Math.floor(players[i] / m);

    // 3. 부족한 서버만큼 추가
    if (need > active) {
      const add = need - active;
      answer += add;
      active += add;

      // k시간 뒤에 반납 예약
      release[i + k] += add;
    }
  }

  return answer;
}
