package fragment;

import java.util.ArrayList;

import model.ChatModel;
import model.ItemModel;

/**
 * Created by：Administrator on 2015/12/21 16:43
 */
public class TestData {

    public static ArrayList<ItemModel> getTestAdData() {
        ArrayList<ItemModel> models = new ArrayList<>();
        ChatModel model = new ChatModel();
        model.setContent("有人在家吗？");
        model.setIcon("https://s26.postimg.cc/maikg4u9l/man.png");
        models.add(new ItemModel(ItemModel.CHAT_A, model));
        ChatModel model2 = new ChatModel();
        model2.setContent("怎么了？");
        model2.setIcon("https://s26.postimg.cc/orubndyqh/woman.png");
        models.add(new ItemModel(ItemModel.CHAT_B, model2));
        ChatModel model3 = new ChatModel();
        model3.setContent("芦荟该浇水了");
        model3.setIcon("https://s26.postimg.cc/maikg4u9l/man.png");
        models.add(new ItemModel(ItemModel.CHAT_A, model3));
        ChatModel model4 = new ChatModel();
        model4.setContent("哦哦，我知道了，我很快就下班了，一会回家了就给它浇水");
        model4.setIcon("https://s26.postimg.cc/orubndyqh/woman.png");
        models.add(new ItemModel(ItemModel.CHAT_B, model4));
        ChatModel model5 = new ChatModel();
        model5.setContent("你知道要浇多少水吗？");
        model5.setIcon("https://s26.postimg.cc/maikg4u9l/man.png");
        models.add(new ItemModel(ItemModel.CHAT_A, model5));
        ChatModel model6 = new ChatModel();
        model6.setContent("知道啊，以前我浇过");
        model6.setIcon("https://s26.postimg.cc/orubndyqh/woman.png");
        models.add(new ItemModel(ItemModel.CHAT_B, model6));

        ChatModel model7 = new ChatModel();
        model7.setContent("嗯");
        model7.setIcon("https://s26.postimg.cc/maikg4u9l/man.png");
        models.add(new ItemModel(ItemModel.CHAT_A, model7));

        ChatModel model8 = new ChatModel();
        model8.setContent("你什么时候回家啊？");
        model8.setIcon("https://s26.postimg.cc/orubndyqh/woman.png");
        models.add(new ItemModel(ItemModel.CHAT_B, model8));

        ChatModel model9 = new ChatModel();
        model9.setContent("再过半个小时就回家了，我这边有个bug还没找出来");
        model9.setIcon("https://s26.postimg.cc/maikg4u9l/man.png");
        models.add(new ItemModel(ItemModel.CHAT_A, model9));

        ChatModel model10 = new ChatModel();
        model10.setContent("嗯，加油啊。我给你买个四阿哥的贴纸吧，你挂在你的工作台旁边");
        model10.setIcon("https://s26.postimg.cc/orubndyqh/woman.png");
        models.add(new ItemModel(ItemModel.CHAT_B, model10));

        ChatModel model11 = new ChatModel();
        model11.setContent("要四阿哥的贴纸干什么啊？");
        model11.setIcon("https://s26.postimg.cc/maikg4u9l/man.png");
        models.add(new ItemModel(ItemModel.CHAT_A, model11));

        ChatModel model12 = new ChatModel();
        model12.setContent("你不知道四阿哥能管得住八阿哥吗？");
        model12.setIcon("https://s26.postimg.cc/orubndyqh/woman.png");
        models.add(new ItemModel(ItemModel.CHAT_B, model12));

        ChatModel model13 = new ChatModel();
        model13.setContent("噗。。。哈哈哈哈，可以啊");
        model13.setIcon("https://s26.postimg.cc/maikg4u9l/man.png");
        models.add(new ItemModel(ItemModel.CHAT_A, model13));

        ChatModel model14 = new ChatModel();
        model14.setContent("我一会儿上淘宝给你找找");
        model14.setIcon("https://s26.postimg.cc/orubndyqh/woman.png");
        models.add(new ItemModel(ItemModel.CHAT_B, model14));

        ChatModel model15 = new ChatModel();
        model15.setContent("嗯嗯！");
        model15.setIcon("https://s26.postimg.cc/maikg4u9l/man.png");
        models.add(new ItemModel(ItemModel.CHAT_A, model15));


        ChatModel model16 = new ChatModel();
        model16.setContent("那个风信子好像开花了呢");
        model16.setIcon("https://s26.postimg.cc/orubndyqh/woman.png");
        models.add(new ItemModel(ItemModel.CHAT_B, model16));

        ChatModel model17 = new ChatModel();
        model17.setContent("是吗？今天早上出门的时候还没有开花");
        model17.setIcon("https://s26.postimg.cc/maikg4u9l/man.png");
        models.add(new ItemModel(ItemModel.CHAT_A, model17));

        ChatModel model18 = new ChatModel();
        model18.setContent("有一种特别的香味");
        model18.setIcon("https://s26.postimg.cc/orubndyqh/woman.png");
        models.add(new ItemModel(ItemModel.CHAT_B, model18));


        ChatModel model19 = new ChatModel();
        model19.setContent("是的，有的人不喜欢闻这个味道，你喜欢这个味道吗？");
        model19.setIcon("https://s26.postimg.cc/maikg4u9l/man.png");
        models.add(new ItemModel(ItemModel.CHAT_A, model19));


        ChatModel model20 = new ChatModel();
        model20.setContent("喜欢啊，我感觉挺好闻的");
        model20.setIcon("https://s26.postimg.cc/orubndyqh/woman.png");
        models.add(new ItemModel(ItemModel.CHAT_B, model20));


        ChatModel model21 = new ChatModel();
        model21.setContent("嗯嗯，我先去debug了啊，一会儿回家了再说");
        model21.setIcon("https://s26.postimg.cc/maikg4u9l/man.png");
        models.add(new ItemModel(ItemModel.CHAT_A, model21));


        ChatModel model22 = new ChatModel();
        model22.setContent("嗯");
        model22.setIcon("https://s26.postimg.cc/orubndyqh/woman.png");
        models.add(new ItemModel(ItemModel.CHAT_B, model22));


        return models;
    }

}
