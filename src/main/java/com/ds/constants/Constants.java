package com.ds.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoshengzhen
 * @date 2025-02-26 13:22
 * @desc:
 **/
public class Constants {
    public static final String url = "https://api.deepseek.com/chat/completions";
    public static final String api_key = "Bearer sk-5f4e77c3ca4b45c1b23406a060439c1d";
    //模型ID
    public static final String model = "deepseek-chat";
    //频率惩罚：介于 -2.0 和 2.0 之间的数字。如果该值为正，那么新 token 会根据其在已有文本中的出现频率受到相应的惩罚，降低模型重复相同内容的可能性。
    public static final float frequency_penalty = 0;
    //最大token值，默认4096
    public static final int max_tokens = 4096;
    //出席处罚：介于 -2.0 和 2.0 之间的数字。如果该值为正，那么新 token 会根据其是否已在已有文本中出现受到相应的惩罚，从而增加模型谈论新主题的可能性。
    public static final float presence_penalty = 0;
    //public static final Object response_format = new HashMap[];
    //一个 string 或最多包含 16 个 string 的 list，在遇到这些词时，API 将停止生成更多的 token
    public static final String stop = null;
    //如果设置为 True，将会以 SSE（server-sent events）的形式以流式发送消息增量。消息流以 data: [DONE] 结尾。
    public static final boolean stream = false;
    //流式输出相关选项。只有在 stream 参数为 true 时，才可设置此参数。
    //include_usage
    //boolean
    //如果设置为 true，在流式消息最后的 data: [DONE] 之前将会传输一个额外的块。此块上的 usage 字段显示整个请求的 token 使用统计信息，而 choices 字段将始终是一个空数组。所有其他块也将包含一个 usage 字段，但其值为 null。
    public static final Object stream_options= null;
    //采样温度，介于 0 和 2 之间。更高的值，如 0.8，会使输出更随机，而更低的值，如 0.2，会使其更加集中和确定。 我们通常建议可以更改这个值或者更改
    public static final int temperature = 1;
    //作为调节采样温度的替代方案，模型会考虑前 top_p 概率的 token 的结果。所以 0.1 就意味着只有包括在最高 10% 概率中的 token 会被考虑。 我们通常建议修改这个值或者更改 temperature，但不建议同时对两者进行修改。
    public static final int top_p=1;

    public static final Object tools= null;
    public static final String tool_choice= "none";
    public static final boolean logprobs = false;
    public static final String  top_logprobs= null;
}
