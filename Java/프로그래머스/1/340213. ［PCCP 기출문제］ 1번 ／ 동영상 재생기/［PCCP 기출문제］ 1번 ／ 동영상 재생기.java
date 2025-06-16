class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
       
        int videoLength = timeToSeconds(video_len);
        int position = timeToSeconds(pos);
        int opStart = timeToSeconds(op_start);
        int opEnd = timeToSeconds(op_end);

        for (String command : commands) {
            
            if (position >= opStart && position <= opEnd) {
                position = opEnd;
            }

            if (command.equals("next")) {
                position += 10;
                if (position > videoLength) {
                    position = videoLength;
                }
            } else if (command.equals("prev")) {
                position -= 10;
                if (position < 0) {
                    position = 0;
                }
            }
        }

       
        if (position >= opStart && position <= opEnd) {
            position = opEnd;
        }

        return secondsToTime(position);
    }

    
    private int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

   
    private String secondsToTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
