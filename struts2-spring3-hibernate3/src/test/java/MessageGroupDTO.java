/**
 * Author: Hu jing ling
 * Date: 12-6-12
 * Description: put description for the type here...
 */
public class MessageGroupDTO{

    private String category; //消息分类
    private int categorySeq; //排序
    private String unreadNum; //未读消息数
    private String totalNum; //总消息数

    public MessageGroupDTO() {
    }

    @Override
    public String toString() {
        return "MessageGroupDTO{" +
                "category='" + category + '\'' +
                ", categorySeq=" + categorySeq +
                ", unreadNum='" + unreadNum + '\'' +
                ", totalNum='" + totalNum + '\'' +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnreadNum() {
        return unreadNum;
    }

    public void setUnreadNum(String unreadNum) {
        this.unreadNum = unreadNum;
    }

    public String getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    public int getCategorySeq() {
        return categorySeq;
    }

    public void setCategorySeq(int categorySeq) {
        this.categorySeq = categorySeq;
    }
}
