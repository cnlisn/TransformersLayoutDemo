

# TransformersLayout

> :fire: APP变形金刚区导航布局，下方带横向滚动条，很多APP都有使用这种
>
> 整体结构是Recyclerview + 滚动条

### Features

- 每页行数、列数可配置
- 滚动状态自动恢复
- item布局样式自定义
- scrollbar样式可配置

# Preview
![Image text]()


**Step 1：** xml布局文件

```xml
<com.lisn.transformerslayout.TransformersLayout                                         
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="#ffffff"
    app:tl_spanCount="5"
    app:tl_lines="2"
    app:tl_scrollbarWidth="72dp"
    app:tl_scrollbarHeight="4dp"
    app:tl_scrollbarRadius="2dp"
    app:tl_scrollbarMarginTop="6dp"
    app:tl_scrollbarTrackColor="#f0f0f0"
    app:tl_scrollbarThumbColor="#FFC107"/>
```

**Step 2：** 自定义ViewHolder，第三步需要用到

```java
public class NavAdapterViewHolder extends Holder<Nav> {
    private ImageView icon;
    private TextView text;

    NavAdapterViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    protected void initView(View itemView) {
        icon = itemView.findViewById(R.id.iv_menu_icon);
        text = itemView.findViewById(R.id.tv_menu_text);
    }

    @Override
    public void bindData(Context context, Nav data) {
        text.setText(data.getText());
        Glide.with(context)
                .asBitmap()
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.default_place_holder)
                .load(data.getUrl())
                .into(icon);
    }
}
```

**Step 3：** java代码中使用

```java
List<Nav> navList = DataFactory.loadData();
TransformersLayout<Nav> header = findViewById();
//options可选配置
TransformersOptions options = new TransformersOptions.Builder()
        .lines(2)
        .spanCount(5)
        .scrollBarWidth(Util.dp2px(this, 40))
        .scrollBarHeight(Util.dp2px(this, 3))
        .scrollBarRadius(Util.dp2px(this, 3) / 2f)
        .scrollBarTopMargin(Util.dp2px(this, 6))
        .build();
header.apply(options)
        .addOnTransformersItemClickListener(new OnTransformersItemClickListener() {
            @Override
            public void onItemClick(int position) {
                showToast();
            }
        })
        .load(navList, new TransformersHolderCreator<Nav>() {
            @Override
            public Holder<Nav> createHolder(View itemView) {
                return new NavAdapterViewHolder(itemView);
            }
            @Override
            public int getLayoutId() {
                return R.layout.item_nav_list;
            }
        });
```


### 支持的attrs属性：

| Attributes | Format | Description |
| -------- | ---- | ---- |
| tl_spanCount | integer | 每页列数，默认5 |
| tl_lines | integer | 每页行数，默认2 |
| tl_scrollbarWidth | dimension \| reference | scrollbar宽度，默认36dp |
| tl_scrollbarHeight | dimension \| reference | scrollbar高度，默认3dp |
| tl_scrollbarMarginTop | dimension \| reference | scrollbar上间距 |
| tl_scrollbarRadius | dimension \| reference | scrollbar圆角，默认高度的一半 |
| tl_scrollbarTrackColor | color \| reference | scrollbar轨道颜色 |
| tl_scrollbarThumbColor | color \| reference | scrollbar高亮颜色 |

