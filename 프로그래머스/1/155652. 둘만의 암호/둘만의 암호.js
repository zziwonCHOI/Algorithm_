function solution(s, skip, index) {
    const isSkip = Array(26).fill(false);
    for (const c of skip) {
        isSkip[c.charCodeAt(0) - 97] = true;
    }

    // skip을 제외한 알파벳 배열 생성
    const possible = [];
    for (let i = 0; i < 26; i++) {
        if (!isSkip[i]) {
            possible.push(String.fromCharCode(i + 97));
        }
    }

    const result = [];

    for (const c of s) {
        // 현재 문자의 위치 찾기
        const cur = possible.indexOf(c);

        // index만큼 이동
        const next = (cur + index) % possible.length;
        result.push(possible[next]);
    }

    return result.join('');
}