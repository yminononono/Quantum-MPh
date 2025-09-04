import yaml

def evaluate_config(config):
    """
    dict を再帰的に探索し、'eval:' 付きの値を評価して置き換える
    """
    if isinstance(config, dict):
        for k, v in config.items():
            if isinstance(v, str) and v.strip().startswith("eval:"):
                expr = v.split("eval:", 1)[1].strip()
                # 同じ階層の dict を評価環境として渡す
                config[k] = eval(expr, {}, config)
            else:
                config[k] = evaluate_config(v)
    elif isinstance(config, list):
        return [evaluate_config(x) for x in config]
    return config

def load_config(filename):

    with open(filename, 'r') as _file:
        config = yaml.safe_load(_file)
        config = evaluate_config(config)
        
    return config