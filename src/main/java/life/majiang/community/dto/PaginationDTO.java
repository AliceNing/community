package life.majiang.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//定义一个分页中所有要展示的内容
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;//问题列表
    private boolean showPrevious;//是否展示上一页按钮
    private boolean showFirstPage;//是否展示首页按钮
    private boolean showNext;//是否展示下一页按钮
    private boolean showEndPage;//是否展示尾页按钮
    private Integer page;//当前在第几分页？
    private List<Integer> pages = new ArrayList<>();//展示哪些分页链接？
    private Integer totalPage;//记录总的分页数

    //totalCount 是所有的问题数量，page是当前在第几分页，size是一页里展示的问题数量。
    public void setPagination(Integer totalCount, Integer page, Integer size) {
        setTotalPage(totalCount,size);
        this.page = page;
        pages.add(page);
        for (int i =1;i<=3;i++){
            if (page-i>0){//当前页前面若有三个分页，则加入分页链接列表里，插到头的位置。
                pages.add(0,page-i);
            }

            if (page+i <=totalPage){//当前页面之后若有三个分页，则加入分页链接列表里，插到尾部的位置。
                pages.add(page+i);
            }
        }

        //是否展示上一页
        if (page ==1){
            showPrevious =false;
        }else {
            showPrevious = true;
        }

        //是否展示下一页
        if (page ==totalPage){
            showNext = false;
        }else {
            showNext = true;
        }

        //是否展示首页
        if (pages.contains(1)){//page -size <=1
            showFirstPage = false;
        }else {
            showFirstPage = true;
        }

        //是否展示尾页
        if (pages.contains(totalPage)){//page+size >totalPage
            showEndPage = false;
        }else {
            showEndPage = true;
        }
    }

    public void setTotalPage(Integer totalCount, Integer size) {
        if(totalCount % size ==0){
            totalPage = totalCount / size;
        }else {
            totalPage = totalCount /size +1;
        }
    }
}
