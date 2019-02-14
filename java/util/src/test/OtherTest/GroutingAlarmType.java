package test.OtherTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 压浆
 * Created by wuchen on 2018/8/10.
 */
public enum GroutingAlarmType {

    LOW("低级", 1,"L",0.7,180),
    HIGH("高级", 3,"H",1.0,160);
    private String text;
    private Integer type;
    private String mark;
    private Double threshold;
    private Integer warningTime;

    GroutingAlarmType(String text, Integer type, String mark, Double threshold, Integer warningTime) {
        this.text = text;
        this.type = type;
        this.mark = mark;
        this.threshold = threshold;
        this.warningTime = warningTime;
    }

    public static JSONArray getJson() {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        for (GroutingAlarmType type : GroutingAlarmType.values()) {
            jsonObject = new JSONObject();
            jsonObject.put("text", type.getText());
            jsonObject.put("type", type.getType());
            jsonObject.put("threshold", type.getThreshold());
            jsonObject.put("mark", type.getMark());
            jsonObject.put("warningTime", type.getWarningTime());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    public static String getMark(Integer value){
        for (GroutingAlarmType type : GroutingAlarmType.values()) {
            if (type.getType().equals(value)) {
                return type.getMark();
            }
        }
        return "";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

    public Integer getWarningTime() {
        return warningTime;
    }

    public void setWarningTime(Integer warningTime) {
        this.warningTime = warningTime;
    }
}
